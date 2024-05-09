package vn.tinhh.workplan.manager;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import vn.tinhh.workplan.bases.BaseModel;
import vn.tinhh.workplan.enums.StatusEnum;
import vn.tinhh.workplan.exception.DuplicateRecordFound;
import vn.tinhh.workplan.utils.QueryBuilderUtils;

import java.util.*;

@Repository
@Getter
@Setter
public class ConnectorManager {
    @Autowired
    protected MongoTemplate mongoTemplate;
    protected String collectionName = "connector";
    @Autowired
    private IdRenderManager sequenceManager;


    private Map<String, Object> create(String fromCollection, String fromId, String toCollection, String toId, String type, Map<String, Object> map, String updatedBy) throws DuplicateRecordFound {
        if (!ObjectUtils.isEmpty(fromCollection) && !ObjectUtils.isEmpty(fromId) && !ObjectUtils.isEmpty(toCollection) && !ObjectUtils.isEmpty(type) && !ObjectUtils.isEmpty(toId) && !ObjectUtils.isEmpty(toCollection)) {
            if (this.mongoTemplate.exists(Query.query(this.buildQuery(fromCollection, Arrays.asList(fromId), toCollection, toId, type, StatusEnum.RelatedObjectsStatus.ACTIVE.getValue())), Map.class, "connector")) {
                throw new DuplicateRecordFound("Related Object existed");
            }
            List<Map> rs = this.mongoTemplate.find(Query.query(this.buildQuery(fromCollection, Arrays.asList(fromId), toCollection, toId, type, StatusEnum.RelatedObjectsStatus.ACTIVE.getValue())), Map.class, "connector");
            if (!ObjectUtils.isEmpty(rs)) {
                return (Map) rs.get(0);
            }
        }

        return (Map) (!ObjectUtils.isEmpty(map) ? this.createObject(map, updatedBy, "connector") : new HashMap());
    }

    private Criteria buildQuery(String fromCollection, List<String> fromIds, String toCollection, String toId, String type, Integer status) {
        Criteria criteria = new Criteria();
        List<Criteria> filterList = new ArrayList();
        if (!ObjectUtils.isEmpty(fromCollection)) {
            filterList.add(Criteria.where(fromCollection + "_id").exists(true));
        }

        if (!ObjectUtils.isEmpty(toCollection)) {
            filterList.add(Criteria.where(toCollection + "_id").exists(true));
        }

        QueryBuilderUtils.addMultipleValuesFilter(filterList, fromCollection + "_id", fromIds);
        QueryBuilderUtils.addSingleValueFilter(filterList, toCollection + "_id", toId);
        QueryBuilderUtils.addSingleValueFilter(filterList, "status", status);
        QueryBuilderUtils.addSingleValueFilter(filterList, "type", type);
        QueryBuilderUtils.andOperator(criteria, filterList);
        return criteria;
    }

    private Object createObject(Object object, String updateBy, String collectionName) {
        Assert.notNull(object, "Object must not null");
        if (object instanceof BaseModel) {
            BaseModel baseModel = (BaseModel) object;
            if (null == baseModel.getId()) {
                baseModel.setId(this.sequenceManager.renderIdForAdd(this.getCollectionName()));
            }

            if (null == baseModel.getCreatedStamp()) {
                baseModel.setCreatedStamp(new Date());
            }

            baseModel.setUpdatedBy(updateBy);
            baseModel.setCreatedBy(updateBy);
        }

        Object newObject = this.mongoTemplate.insert(object, collectionName);
        return newObject;
    }

}
