//
//  calculate.h
//  calculate
//
//  Created by XQ on 2018/12/8.
//  Copyright © 2018年 XQ. All rights reserved.
//

#ifndef calculate_h
#define calculate_h
#import <Foundation/Foundation.h>
#import "Stack.h"
#endif /* calculate_h */



char OP[8] = {'+','-','*','/','%','(',')','#'};  //运算符集合
int priority[8][8] =   //各运算符相遇时，优先级比较 1:大于，2:小于，3:等于，0:不可能，错误
{
    { 1, 1, 2, 2, 2, 2, 1, 1 },
    { 1, 1, 2, 2, 2, 2, 1, 1 },
    { 1, 1, 1, 1, 1, 2, 1, 1 },
    { 1, 1, 1, 1, 1, 2, 1, 1 },
    { 1, 1, 1, 1, 1, 2, 1, 1 },
    { 2, 2, 2, 2, 2, 2, 3, 0 },
    { 1, 1, 1, 1, 1, 0, 1, 1 },
    { 2, 2, 2, 2, 2, 2, 0, 3 }
};
bool isOpat(char c)   //是否是OP[]中的操作符
{
    for (int i = 0; i < 8; i++)
    {
        if (c == OP[i])
            return true;
    }
    return false;
}
int getPriority(char c1,char c2)  //比较优先级
{
    int i=0, j=0;
    for (int r = 0; r < 8; r++)
    {
        if (c1 == OP[r])
            i = r;
        if (c2 == OP[r])
            j = r;
    }
    return priority[i][j];
}
int compute(char _a, char op, char _b)
{
    int a = _a - '0';
    int b = _b - '0';
    switch (op)
    {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a*b;
        case '/':
        case '%':
            if (b == 0)
            {
                NSLog(@"error");
                exit(0);
            }
            if (op == '/')
                return a / b;
            else
                return a%b;
            
    }
    return 0;
}
void evaluateExpression()   //计算
{
    
    Stack * opan = [[Stack alloc] init];
    Stack * opat = [[Stack alloc] init];
    NSLog(@"输入算术表达式");
    [opat push:'#'];
    char op,c,cn;    //cn:char next下一个字符
    char a,b;
    int data;
    c=getchar();
    if (isOpat(c))   //如果第一个字符就是操作符，则把0压入数字栈
        [opan push:'0'];
    while (c!='#' || [[opat getTop] getValue] != '#')  //没有读到 '#'，或者符号栈也没空，则继续读取字符
    {
        //对读入的字符进行判断：是操作数还是操作符？
        if (!isOpat(c))  //是操作数则压入操作数栈
        {
            data = c - '0';
            while (!isOpat(cn = getchar()))   //下一个字符任为数字
            {
                data = data * 10 + cn - '0';
            }
            [opan push:(data+'0')];
            c = cn;   //把cn中的操作符赋给c
        }
        else   //若是操作符，则需把符号栈顶的操作符与当前读入的操作符，进行优先级比较
        {
            switch(getPriority([[opat getTop] getValue], c))
            {
                case 1:
                    op = [[opat getTop] getValue]; [opat pop];
                    
                    b = [[opan getTop] getValue]; [opan pop];
                    a = [[opan getTop] getValue]; [opan pop];
                    [opan push:(compute(a,op,b)+'0')];
                    break;
                case 2:
                    [opat push:c];
                    c = getchar();
                    break;
                case 3:
                    [opat pop];
                    c = getchar();
                    break;
                case 0:

                    break;
            }
        }
    }
    NSLog(@"%d", [[opan getTop] getValue]-'0');
}


