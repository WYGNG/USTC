//
//  DulList.cpp
//  DulList
//
//  Created by XQ on 2017/3/29.
//  Copyright © 2017年 XQ. All rights reserved.
//

#include "DulList.hpp"


pDulNode DulList::create_DulList(){
    int len;
    valuetype buf;
    cout << "Please input the list's length." << endl;
    cin >> len;
    length = len;
    head = (pDulNode)malloc(sizeof(DulNode));
    head->prior = NULL;
    head->next = NULL;
    head->data = len;
    pDulNode s = head;
    if(!head){exit(-1);}
    cout << "Please input " << length << " number." << endl;
    for(int count = 0 ; count < len ; count ++){
        cin >> buf;
        pDulNode p = (pDulNode)malloc(sizeof(DulNode));
        s->next = p;
        p->prior = s;
        p->next = NULL;
        p->data = buf;
        s = s->next;
        tail = p;
    }

    return head;
}//

bool DulList::traverse_DulList(pDulNode L){
    pDulNode p = L;
    while(p->next){
        p = p->next;
        cout << p->data << " ";
    }
    cout << endl;
    return true;
}//

bool DulList::insert_DulList(pDulNode &L, int i, int e){
    pDulNode p = L;
    if(i > length){cout << "i is too high." << endl;return false;}
    if(p->next){
        for(int count = 0 ; count < i ; count ++){
            p = p->next;
        }
        if(p->next){
            pDulNode s = (pDulNode)malloc(sizeof(DulNode));
            s->data = e;
            p->next->prior = s;
            s->prior = p;
            s->next = p->next;
            p->next = s;
            length ++;
        }
        else{
            pDulNode s = (pDulNode)malloc(sizeof(DulNode));
            s->next = NULL;
            s->data = e;
            s->prior = p;
            p->next = s;
            length ++;
        }
    }
    
    return true;
}//


bool DulList::delete_DulList_i(pDulNode &L, int i){
    pDulNode p = L;
    if(i > length){cout << "i is too high." << endl;return false;}
    if(p->next){
        for(int count = 0 ; count < i ; count ++){
            p = p->next;
        }
        pDulNode s = p->next;
        if(s){s->prior = p->prior;}
        p->prior->next = s;
        free(p);
        length --;
    }
    return true;
}//

bool DulList::delete_DulList_e(pDulNode &L, int e){
    pDulNode p = L;
    while(p->next){
            p = p->next;
            if(p->data == e){
                pDulNode s = p->next;
                if(s){s->prior = p->prior;}
                p->prior->next = s;
                free(p);
                length --;
            }
    }
    return true;
}//

bool DulList::replace_DulList_j(pDulNode &L, int j,int e){
    pDulNode p = L;
    if(j > length){cout << "j is too high." << endl;return false;}
    if(p->next){
        for(int count = 0 ; count < j ; count ++){
            p = p->next;
        }
        p->data = e;
    }
    return true;
}//

bool DulList::replace_DulList_e(pDulNode &L, int e1, int e2){
    pDulNode p = L;
    while(p->next){
        p = p->next;
        if(p->data == e1){
            p->data = e2;
        }
    }
    return true;
}//

int DulList::search_DulList(pDulNode &L, int e){
    int count = 0;
    int i = 0;
    pDulNode p = L;
    while(p->next){
        p = p->next;
        i ++;
        if(p->data == e){
            count ++;
            if(count == 1){cout << i << endl;}
        }
        
    }
    return count;
}//

bool DulList::sort_DulList(pDulNode &L){
    pDulNode p = L->next;
    int count = 0;
    while(p){
        pDulNode s = p->next;
        count ++;
        while(s){
            if(s->data < p->data){
              swap(s->data, p->data);
            }
            s = s->next;
        }
        
        p = p->next;
    }
    return true;
}
