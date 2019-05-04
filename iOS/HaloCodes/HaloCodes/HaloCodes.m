//
//  HaloCodes.m
//  HaloCodes
//
//  Created by XQ on 2018/11/29.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "HaloCodes.h"

@implementation HaloCodes
@synthesize something = _something;

- (void)setSomething:(NSString *)something{
    NSMutableString * halo = [NSMutableString stringWithString:something];
    [halo appendString:@"!😆"];
    _something = halo;
}
- (NSString *)something{
    return _something;
}


+ (void)sayHaloCodes{
    
    NSLog(@"%@!",@"Halo Codes");
}

- (void)sayHalo:(NSString *)string{
    NSString * halo = @"Halo ";
    NSMutableString * res = [NSMutableString stringWithString:halo];
    [res appendString:string];
    NSLog(@"%@!",res);
}
- (void)saySomething{
    NSString * halo = @"Halo ";
    NSMutableString * res = [NSMutableString stringWithString:halo];
    [res appendString:self.something];
    NSLog(@"%@",res);
}

@end
