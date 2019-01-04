//
//  ViewController.h
//  StudentScore
//
//  Created by XQ on 2019/1/3.
//  Copyright © 2019年 XQ. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "TableViewController.h"
@interface ViewController : UIViewController
@property (strong, nonatomic) NSMutableArray * students;
@property (strong, nonatomic) NSIndexPath * indexPath;
@property (strong, nonatomic) NSString * path;

@end

