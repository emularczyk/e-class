//package com.example.demo.config;
//
//import com.example.demo.grade.Grade;
//import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
//import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
//
//public class UuidIdentifiedEntityEventListener extends AbstractMongoEventListener<Grade> {
//
//    @Override
//    public void onBeforeConvert(BeforeConvertEvent<Grade> event) {
//
//        super.onBeforeConvert(event);
//        Grade entity = event.getSource();
//
//        if (entity.getGradeId() == null) {
//            entity.setGradeId(new ObjectId()); // uuid
//        }
//    }
//}