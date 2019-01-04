//
//  Student.m
//  StudentScore
//
//  Created by XQ on 2019/1/4.
//  Copyright © 2019年 XQ. All rights reserved.
//

#import "Student.h"

@implementation Student

- (void)encodeWithCoder:(nonnull NSCoder *)aCoder {
    [aCoder encodeObject:self.name forKey:@"name"];
    [aCoder encodeObject:self.number forKey:@"number"];
    [aCoder encodeInteger:self.age forKey:@"age"];
    [aCoder encodeFloat:self.score forKey:@"score"];
    [aCoder encodeObject:self.teacher forKey:@"teacher"];
    [aCoder encodeObject:self.memo forKey:@"memo"];
}

- (nullable instancetype)initWithCoder:(nonnull NSCoder *)aDecoder {
    if(self = [super init]){
        self.name = [aDecoder decodeObjectForKey:@"name"];
        self.number = [aDecoder decodeObjectForKey:@"number"];
        self.age = [aDecoder decodeIntegerForKey:@"age"];
        self.score = [aDecoder decodeFloatForKey:@"score"];
        self.teacher = [aDecoder decodeObjectForKey:@"teacher"];
        self.memo = [aDecoder decodeObjectForKey:@"memo"];
        
    }
    return self;
}

@end
