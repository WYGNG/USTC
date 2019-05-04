//
//  TableViewController.h
//  StudentScore
//
//  Created by XQ on 2019/1/4.
//  Copyright © 2019年 XQ. All rights reserved.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface TableViewController : UITableViewController
- (void) writeToFile:(NSMutableArray *) sts filePath:(NSString *)path;
@end

NS_ASSUME_NONNULL_END
