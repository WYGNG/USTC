//
//  HaloCodes.h
//  HaloCodes
//
//  Created by XQ on 2018/11/29.
//  Copyright © 2018年 XQ. All rights reserved.
//

#ifndef HaloCodes_h
#define HaloCodes_h
#import <Foundation/Foundation.h>

#endif /* HaloCodes_h */
@interface HaloCodes : NSObject
@property (strong,nonatomic) NSString * something;

+ (NSString *)sayHaloCodes;
- (NSString *)sayHalo:(NSString *)string;
- (NSString *)saySomething;

@end
