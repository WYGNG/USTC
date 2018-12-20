//
//  advanceCalculator.m
//  CalculaterGUI
//
//  Created by XQ on 2018/12/16.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "advanceCalculator.h"

@implementation advanceCalculator



- (NSString *)sqrt:(NSString *)content{
    double d = [content doubleValue];
    double res = sqrt(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
-(NSString *)abs:(NSString *)content{
    double d = [content doubleValue];
    double res = fabs(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)x1:(NSString *)content{
    double d = [content doubleValue];
    double res = 1.0/d;
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)x_2:(NSString *)content{
    double d = [content doubleValue];
    double res = pow(d,2);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)x_3:(NSString *)content{
    double d = [content doubleValue];
    double res = pow(d,3);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)ln:(NSString *)content{
    double d = [content doubleValue];
    double res = log(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)log:(NSString *)content{
    double d = [content doubleValue];
    double res = log10(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}

- (NSString *)sin:(NSString *)content{
    double d = [content doubleValue];
    double res = sin(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)cos:(NSString *)content{
    double d = [content doubleValue];
    double res = cos(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)tan:(NSString *)content{
    double d = [content doubleValue];
    double res = tan(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}

- (NSString *)asin:(NSString *)content{
    double d = [content doubleValue];
    double res = asin(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)acos:(NSString *)content{
    double d = [content doubleValue];
    double res = acos(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)atan:(NSString *)content{
    double d = [content doubleValue];
    double res = atan(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)sinh:(NSString *)content{
    double d = [content doubleValue];
    double res = sinh(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)cosh:(NSString *)content{
    double d = [content doubleValue];
    double res = cosh(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}
- (NSString *)tanh:(NSString *)content{
    double d = [content doubleValue];
    double res = tanh(d);
    NSNumber * n = [[NSNumber alloc]initWithDouble: res];
    return [n stringValue];
}




- (void)deleteNumber{
 
    long length = self.string.length - 1;
    if(length >= 0){
        [self.string deleteCharactersInRange:NSMakeRange(length,1)];
        //[self.screen deleteCharactersInRange:NSMakeRange(length, 1)];
    }
    
}
- (void)clearString{
    self.string = nil;
    self.screen = [NSMutableString stringWithString:@""];
}





@end
