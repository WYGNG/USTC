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
-(NSString *)abs:(NSString *) content;
-(NSString *)x1:(NSString *) content;
-(NSString *)x_2:(NSString *) content;

-(NSString *)x_3:(NSString *) content;
-(NSString *)sin:(NSString *) content;
-(NSString *)cos:(NSString *) content;
-(NSString *)tan:(NSString *) content;

-(NSString *)asin:(NSString *) content;
-(NSString *)acos:(NSString *) content;
-(NSString *)stan:(NSString *) content;
-(NSString *)ln:(NSString *) content;

-(NSString *)sinh:(NSString *) content;
-(NSString *)cosh:(NSString *) content;
-(NSString *)tanh:(NSString *) content;
-(NSString *)log:(NSString *) content;
@end

NS_ASSUME_NONNULL_END
