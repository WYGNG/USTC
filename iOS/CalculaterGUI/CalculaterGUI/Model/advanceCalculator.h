//
//  advanceCalculator.h
//  CalculaterGUI
//
//  Created by XQ on 2018/12/16.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "Calculator.h"
#import <math.h>
NS_ASSUME_NONNULL_BEGIN

@interface advanceCalculator : Calculator
@property (strong,nonatomic) NSMutableString * screen;
-(NSString *)sqrt:(NSString *) content;
@end

NS_ASSUME_NONNULL_END
