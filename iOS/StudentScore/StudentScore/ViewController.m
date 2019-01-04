//
//  ViewController.m
//  StudentScore
//
//  Created by XQ on 2019/1/3.
//  Copyright © 2019年 XQ. All rights reserved.
//

#import "ViewController.h"

#import "model/Student.h"
@interface ViewController ()
@property (weak, nonatomic) IBOutlet UITextField *name_428;
@property (weak, nonatomic) IBOutlet UITextField *number_428;
@property (weak, nonatomic) IBOutlet UITextField *age_428;
@property (weak, nonatomic) IBOutlet UITextField *score_428;
@property (weak, nonatomic) IBOutlet UITextView *memo_428;

@end

@implementation ViewController
- (IBAction)enter_428:(id)sender {
    TableViewController * tc = [[TableViewController alloc]init];
    Student * student = [[Student alloc] init];
    student.name = self.name_428.text;
    student.number = self.number_428.text;
    student.age = [self.age_428.text integerValue];
    student.score = [self.score_428.text floatValue];
    student.memo = self.memo_428.text;
    student.teacher = @"白天";
    
    if(self.indexPath == nil){
        [self.students addObject:student];
        [tc writeToFile:self.students filePath:self.path];
    }
    else{
        self.students[self.indexPath.row] = student;
        [tc writeToFile:self.students filePath:self.path];
    }
    
    [self.navigationController popToRootViewControllerAnimated:YES];
    
    
    
}
- (IBAction)cancle_428:(id)sender {
    //UITableViewController * tc = [[UITableViewController alloc]init];
    //Student * student = [[Student alloc] init];
    self.name_428.text = nil;
    self.number_428.text = nil;
    self.age_428.text = nil;
    self.score_428.text = nil;
    self.memo_428.text = nil;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.


}
- (void)viewWillAppear:(BOOL)animated{
    if(self.indexPath!=nil){
        Student * student = self.students[self.indexPath.row];
        self.name_428.text = student.name;
        self.number_428.text = student.number;
        self.age_428.text = [NSString stringWithFormat:@"%ld",(long)student.age];
        self.score_428.text = [NSString stringWithFormat:@"%.2f", student.score];
        self.memo_428.text = student.memo;
    }
    
    
}

@end
