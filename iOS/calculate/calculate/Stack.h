//
//  Stack.h
//  calculate
//
//  Created by XQ on 2018/11/28.
//  Copyright © 2018年 XQ. All rights reserved.
//

#ifndef Stack_h
#define Stack_h
#import <Foundation/Foundation.h>

#endif /* Stack_h */

@interface StackNode : NSObject
//属性
{
    @public
    NSInteger value;
    StackNode* pre;
    StackNode* next;
}
//实例方法

- (void)setValue:(NSInteger)_value;
- (NSInteger)getValue;

- (void)setPre:(StackNode*)_pre;
- (void)setNext:(StackNode*)_next;
- (void)set:(StackNode*)_pre withNext:(StackNode *)_next;

- (StackNode *)getPre;
- (StackNode *)getNext;



@end

@interface Stack : NSObject
//属性
{
    @public
    NSInteger sum;
    StackNode * top;

}

//实例方法
- (Boolean) isEmpty;
- (void)push:(NSInteger)value;
- (StackNode *)pop;
- (StackNode *)getTop;

@end

