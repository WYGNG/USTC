//
//  Stack.m
//  calculate
//
//  Created by XQ on 2018/11/28.
//  Copyright © 2018年 XQ. All rights reserved.
//


#import "Stack.h"

@implementation StackNode : NSObject
- (instancetype)init
{
    self = [super init];
    if (self) {
        value = 0;
        pre = NULL;
        next = NULL;
    }
    return self;
}
- (void)setValue:(NSInteger)_value{
    value = _value;
}
- (NSInteger)getValue{
    return value;
}

- (void)setPre:(StackNode *)_pre{
    pre = _pre;
}
- (void)setNext:(StackNode *)_next{
    next = _next;
}

- (void)setPre:(StackNode *)_pre setNext:(StackNode *)_next{
    pre = _pre;
    next = _next;
}

- (StackNode *)getPre{
    return pre;
}
-(StackNode *)getNext{
    return next;
}
@end


@implementation Stack : NSObject
- (instancetype)init
{
    self = [super init];
    if (self) {
        sum = 0;
        top = [[StackNode alloc] init];
        [top setValue:sum];
        [top setPre:NULL setNext:NULL];
    }
    return self;
}
- (Boolean)isEmpty{
    if(sum == 0){
        return true;
    }
    else{
        return false;
    }
}
- (void)push:(NSInteger)value{
    StackNode * p = [StackNode new];
    [p setValue:value];
    [p setPre:top setNext:NULL];
    [top setNext:p];
    top = p;
    ++sum;
    

}
- (StackNode *)pop{
    if(sum!=0){
        StackNode * p = top;
        top = [top getPre];
        --sum;
        return p;
    }
    return NULL;
    
    
    
}
- (StackNode *)getTop{
    return top;
}


@end
