//
//  NSObject+Calculator.h
//  CalculaterGUI
//
//  Created by XQ on 2018/12/10.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import <Foundation/Foundation.h>



@interface Calculator : NSObject
@property (strong ,nonatomic) NSMutableString * string;
- (void) deleteNumber;
- (NSString *) returnResult;
- (void) clearString;
@end


