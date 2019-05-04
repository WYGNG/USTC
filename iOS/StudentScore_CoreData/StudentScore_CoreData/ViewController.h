//
//  ViewController.h
//  StudentScore_CoreData
//
//  Created by XQ on 2019/1/4.
//  Copyright © 2019年 XQ. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CoreData/Teacher+CoreDataClass.h"
@interface ViewController : UIViewController
@property (strong, nonatomic) NSMutableArray * students;
@property (strong, nonatomic) NSIndexPath * indexPath;
@property (strong, nonatomic) Teacher * teacher;
@property (strong, nonatomic) NSManagedObjectContext * context;

@end

