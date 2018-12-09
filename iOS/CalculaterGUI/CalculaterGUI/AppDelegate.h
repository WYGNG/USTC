//
//  AppDelegate.h
//  CalculaterGUI
//
//  Created by XQ on 2018/12/9.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <CoreData/CoreData.h>

@interface AppDelegate : UIResponder <UIApplicationDelegate>

@property (strong, nonatomic) UIWindow *window;

@property (readonly, strong) NSPersistentContainer *persistentContainer;

- (void)saveContext;


@end

