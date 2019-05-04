//
//  main.m
//  calculate
//
//  Created by XQ on 2018/11/28.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Stack.h"
//#import "FormulaStringCalcUtility.h"
#import "calculate.h"
int main(int argc, const char * argv[]) {
    
    @autoreleasepool {
        // insert code here...

        /*
        [stack push:1];
        NSLog(@"%ld",[[stack getTop]getValue]);
        [stack push:2];
        NSLog(@"%ld",[[stack getTop]getValue]);
        [stack push:3];
        NSLog(@"%ld",[[stack getTop]getValue]);
        [stack push:4];
        NSLog(@"%ld",[[stack getTop]getValue]);
        [stack push:5];
        NSLog(@"%ld",[[stack getTop]getValue]);
        [stack push:4];
        NSLog(@"%ld",[[stack getTop]getValue]);
        [stack push:3];
        NSLog(@"%ld",[[stack getTop]getValue]);
        [stack push:2];
        NSLog(@"%ld",[[stack getTop]getValue]);
        [stack push:1];
        NSLog(@"%ld",[[stack getTop]getValue]);
        
        NSLog(@"出栈后");
        while(![stack isEmpty]){
            NSLog(@"%ld",[[stack getTop]getValue]);
            [stack pop];
            
        }
        */
        //栈初始化完成
        //等待输入数据
        //处理数据
        //得出结果
        
       
        /*
        while(EOF){
            NSLog(@"等待输入···");
            char str[100] = {0};
            scanf("%s",str);
            NSString * in = [NSString stringWithUTF8String:str];
            
            
            NSString *result = [FormulaStringCalcUtility calcComplexFormulaString:in];
             NSLog(@"结果为%@",result);
        }
        */
        while(EOF){
            NSLog(@"等待输入···");
            //1+2char str[100] = {0};
            //scanf("%s",str);
            //NSString * in = [NSString stringWithUTF8String:str];
            evaluateExpression();
        }
        
        
        
        
        
        
        
        
        
        
        
    }
    return 0;
}
