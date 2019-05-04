//
//  main.m
//  OC语言实现简单的栈
//
//  Created by HEYANG on 16/3/28.
//  Copyright © 2016年 HEYANG. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "StackForNSObject.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // 创建栈
        StackForNSObject* stack = [StackForNSObject new];
        
        NSString* str = @"Hello";// 创建一个栈元素
        [stack push:str];// 将这个元素推进去
        NSLog(@"%@",[[stack popTopElement] class]);// 出栈并返回该元素
        [stack push:str];// 将这个元素推进去
        
        NSString* str2 = @"world";// 创建一个栈元素
        [stack push:str2];// 将这个元素推进去
        
        [stack traversalElementPopStack:^(id objc) {
            NSLog(@"遍历元素：%@",objc);
        }];
        NSLog(@"长度是：%ld",stack.stackLength);
    }
    return 0;
}
