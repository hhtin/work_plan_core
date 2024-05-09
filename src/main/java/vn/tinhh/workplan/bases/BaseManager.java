package vn.tinhh.workplan.bases;

import com.mongodb.client.result.UpdateResult;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.Assert;
import vn.tinhh.workplan.manager.IdRenderManager;

import java.util.*;

public class BaseManager<T> {
    @Autowired
    protected MongoTemplate mongoTemplate;
    protected String collectionName;
    protected Class<T> tClass;
    @Autowired
    private IdRenderManager sequenceManager;

    public BaseManager(String collectionName, Class<T> tClass) {
        this.collectionName = collectionName;
        this.tClass = tClass;
    }

    public BaseManager(MongoTemplate mongoTemplate, String collectionName, Class<T> tClass) {
        this.mongoTemplate = mongoTemplate;
        this.collectionName = collectionName;
        this.tClass = tClass;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    public T getById(String id) {
        return this.mongoTemplate.findById(id, this.tClass, this.collectionName);
    }

    public List<T> getByIds(List<String> ids) {
        return this.mongoTemplate.find(Query.query(Criteria.where("_id").in(ids)), this.tClass, this.collectionName);
    }

    public T create(@NotEmpty T object,@NotEmpty String updateBy) {
        if (object instanceof BaseModel) {
            BaseModel baseModel = (BaseModel) object;
            if (null == baseModel.getId()) {
                baseModel.setId(this.sequenceManager.renderIdForAdd(this.getCollectionName()));
            }

            if (null == baseModel.getCreatedStamp()) {
                baseModel.setCreatedStamp(new Date());
            }
            baseModel.setCreatedBy(updateBy);
        }
        return this.mongoTemplate.insert(object, this.collectionName);
    }

    public List<T> find(@NotEmpty Criteria criteria) {
        return this.mongoTemplate.find(Query.query(criteria), this.tClass, this.collectionName);
    }

    public void updateAttribute(@NotEmpty String id,@NotEmpty String name,@NotEmpty Object value,@NotEmpty String updateBy) {
        Update update = new Update();
        update.set("updatedStamp", new Date());
        update.set("updatedBy", updateBy);
        update.set(name, value);
        UpdateResult updateResult = this.mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(id)), update, this.collectionName);
        Assert.isTrue(updateResult.getModifiedCount() != 0L, "Update record id " + id + " for collection + " + this.collectionName + " is not success!");
    }

    public void updateAttribute(@NotEmpty String id, @NotEmpty Map<String, Object> values, String updateBy) {
        Update update = new Update();
        StringBuilder name = new StringBuilder();
        name.append("Update attribute: ");
        Iterator var6 = values.entrySet().iterator();

        while (var6.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) var6.next();
            Assert.notNull(entry.getValue(), "Attribute " + (String) entry.getKey() + " must not empty ");
            update.set((String) entry.getKey(), entry.getValue());
            name.append((String) entry.getKey()).append(":").append(entry.getValue()).append(";");
        }

        update.set("updatedStamp", new Date());
        update.set("updatedBy", updateBy);
        UpdateResult updateResult = this.mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(id)), update, this.collectionName);
    }

    public void delete(@NotEmpty String id,@NotEmpty String updateBy) {
        this.mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), this.tClass, this.collectionName);}

    public void delete(@NotEmpty Collection<String> ids,@NotEmpty String updateBy) {
        this.mongoTemplate.remove(Query.query(Criteria.where("_id").in(ids)), this.tClass, this.collectionName);
    }

    public boolean checkExist(@NotEmpty String fieldName,@NotEmpty Object value) {
        return this.mongoTemplate.exists(Query.query(Criteria.where(fieldName).is(value)), this.tClass, this.collectionName);
    }
}

