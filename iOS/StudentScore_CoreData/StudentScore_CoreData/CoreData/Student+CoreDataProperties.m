//
//  Student+CoreDataProperties.m
//  StudentScore_CoreData
//
//  Created by XQ on 2019/1/4.
//  Copyright © 2019年 XQ. All rights reserved.
//
//

#import "Student+CoreDataProperties.h"

@implementation Student (CoreDataProperties)

+ (NSFetchRequest<Student *> *)fetchRequest {
	return [NSFetchRequest fetchRequestWithEntityName:@"Student"];
}

@dynamic age;
@dynamic memo;
@dynamic name;
@dynamic number;
@dynamic score;
@dynamic learn;

@end
