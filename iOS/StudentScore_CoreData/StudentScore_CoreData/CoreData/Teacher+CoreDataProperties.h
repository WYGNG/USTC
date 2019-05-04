//
//  Teacher+CoreDataProperties.h
//  StudentScore_CoreData
//
//  Created by XQ on 2019/1/4.
//  Copyright © 2019年 XQ. All rights reserved.
//
//

#import "Teacher+CoreDataClass.h"


NS_ASSUME_NONNULL_BEGIN

@interface Teacher (CoreDataProperties)

+ (NSFetchRequest<Teacher *> *)fetchRequest;

@property (nonatomic) int16_t age;
@property (nullable, nonatomic, copy) NSString *name;
@property (nullable, nonatomic, copy) NSString *number;
@property (nullable, nonatomic, retain) NSSet<Student *> *teach;

@end

@interface Teacher (CoreDataGeneratedAccessors)

- (void)addTeachObject:(Student *)value;
- (void)removeTeachObject:(Student *)value;
- (void)addTeach:(NSSet<Student *> *)values;
- (void)removeTeach:(NSSet<Student *> *)values;

@end

NS_ASSUME_NONNULL_END
