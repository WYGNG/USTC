//
//  Student.h
//  StudentScore
//
//  Created by XQ on 2019/1/4.
//  Copyright © 2019年 XQ. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "TableViewController.h"
#import "ViewController.h"
NS_ASSUME_NONNULL_BEGIN

@interface Student : NSObject<NSCoding>

@property (strong,nonatomic) NSString * name;
@property (strong,nonatomic) NSString * number;
@property (nonatomic) NSInteger age;
@property (nonatomic) float score;
@property (strong,nonatomic) NSString * memo;
@property (strong,nonatomic) NSString * teacher;





@end

NS_ASSUME_NONNULL_END
