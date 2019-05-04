//
//  Calculator+Health.m
//  CalculaterGUI
//
//  Created by XQ on 2018/12/20.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "Calculator+Health.h"

@implementation Calculator (Health)
- (NSString *)computeHealthWithHeight:(NSString *) height withWeight: (NSString *) weight{
    NSMutableString * exp;
    exp = [NSMutableString stringWithString:weight];
    [exp appendString:@"/(("];
    [exp appendString:height];
    [exp appendString:@"/100.0)"];
    [exp appendString:@"*("];
    [exp appendString:height];
    [exp appendString:@"/100.0))"];
    self.string = exp;
    return [NSString stringWithFormat:@"%.2f",[[self returnResult]floatValue]];
}
@end
