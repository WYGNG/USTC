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

- (void)deleteNumber{
 
    long length = self.string.length - 1;
    if(length >= 0){
        [self.string deleteCharactersInRange:NSMakeRange(length,1)];
    }
    if(self.screen.length-1>=0){
        [self.screen deleteCharactersInRange:NSMakeRange(length, 1)];
    }
    
}
- (void)clearString{
    self.string = nil;
    self.screen = [NSMutableString stringWithString:@""];
}





@end
