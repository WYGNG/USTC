//
//  main.m
//  HaloCodes
//
//  Created by XQ on 2018/11/29.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "HaloCodes.h"
int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // insert code here...
        //NSLog(@"Hello, World!");
        NSLog(@"%@!",@"Now,I dont wanna to say 'hello world'");
        HaloCodes * halocodes = [[HaloCodes alloc] init];
        [HaloCodes sayHaloCodes];
        [halocodes sayHalo:@"Codes"];
        halocodes.something = @"Codes";
        [halocodes saySomething];
        
        
        
        
        
    }
    return 0;
}
