//
//  NSObject+Calculator.m
//  CalculaterGUI
//
//  Created by XQ on 2018/12/10.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "Calculator.h"

@implementation Calculator
- (NSMutableString *) string{
    if(!_string){
        _string = [[NSMutableString alloc] init];
    }
    return _string;
}
/*删除数字*/
- (void)deleteNumber{
    long length = self.string.length - 1;
    if(length >= 0){
        [self.string deleteCharactersInRange:NSMakeRange(length, 1)];
    }
}

/*清空*/
- (void)clearString{
    self.string = nil;
}

/*返回结果*/
- (NSString *)returnResult{
    @try {
        NSExpression * exp = [NSExpression expressionWithFormat:self.string];
        id value = [exp expressionValueWithObject:nil context:nil];
        NSLog(@"Result=%f",[value floatValue]);
        self.string = [NSMutableString stringWithString:[value stringValue]];
        return [value stringValue];
    } @catch (NSException *exception) {
        self.string = nil;
        return @"Error";
    } 
    
    
}


@end
