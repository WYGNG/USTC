//
//  main.cpp
//  DulList
//
//  Created by XQ on 2017/3/29.
//  Copyright © 2017年 XQ. All rights reserved.
//

#include "DulList.hpp"
int main(){
    DulList DL;
    while(EOF){
        cout << "//*********START*********//" << endl;
        //create list
        pDulNode DL_Head = DL.create_DulList();
        cout << "The list's number is." << endl;
        DL.traverse_DulList(DL_Head);
        
        /*
        //delete i
        cout << "Select i to delete." << endl;
        int i;
        cin >> i;
        DL.delete_DulList_i(DL_Head,i);
        cout << "The list's number is." << endl;
        DL.traverse_DulList(DL_Head);
       */
        //delete e
        cout << "Select number to delete." << endl;
        int value;
        cin >> value;
        DL.delete_DulList_e(DL_Head,value);
        cout << "The list's number is." << endl;
        DL.traverse_DulList(DL_Head);
        /*
        //insert
        cout << "Select k to insert." << endl;
        int k;
        cin >> k;
        cout << "Select number to insert." << endl;
        int e_insert;
        cin >> e_insert;
        DL.insert_DulList(DL_Head,k,e_insert);
        cout << "The list's number is." << endl;
        DL.traverse_DulList(DL_Head);
        
        //repalce j
        cout << "Select j to replace." << endl;
        int j;
        cin >> j;
        cout << "Select number to replace." << endl;
        int e_replace;
        cin >> e_replace;
        DL.replace_DulList_j(DL_Head, j, e_replace);
        cout << "The list's number is." << endl;
        DL.traverse_DulList(DL_Head);
        
        //repalce e
        cout << "Select e1 to replace." << endl;
        int e1;
        cin >> e1;
        cout << "use e2 to replace e1." << endl;
        int e2;
        cin >> e2;
        DL.replace_DulList_e(DL_Head, e1, e2);
        cout << "The list's number is." << endl;
        DL.traverse_DulList(DL_Head);
        
        //search e
        cout << "Select e to search." << endl;
        int e_search;
        cin >> e_search;
        int count = DL.search_DulList(DL_Head, e_search);
        cout << "The number "<< e_search << " contain " << count << "." << endl;
        cout << "Sorting..." << "List is sorted." << endl;
        DL.sort_DulList(DL_Head);
        DL.traverse_DulList(DL_Head);
         */
        cout << "//*********END*********//" << endl;
    }
    return 0;
}
