//
//  DulList.hpp
//  DulList
//
//  Created by XQ on 2017/3/29.
//  Copyright © 2017年 XQ. All rights reserved.
//

#define valuetype int
#include <stdio.h>
#include <iostream>
#include <mm_malloc.h>

using namespace std;


typedef struct DulNode{
    valuetype data;
    struct DulNode *prior,*next;
}Node, *pDulNode;


class DulList{
public:
    pDulNode create_DulList();//create
    bool traverse_DulList(pDulNode L);//traverse
    bool insert_DulList(pDulNode &L,int i,valuetype e);//insert
    bool delete_DulList_i(pDulNode &L,int i);//delete i
    bool delete_DulList_e(pDulNode &L,valuetype e);//delete e
    bool replace_DulList_j(pDulNode &L,int i,valuetype e);//replace j
    bool replace_DulList_e(pDulNode &L,valuetype e1,valuetype e2);//replace e
    int search_DulList(pDulNode &L,valuetype e);//search
    bool sort_DulList(pDulNode &L);//sort
private:
    int length;
    pDulNode head;
    pDulNode tail;
};
