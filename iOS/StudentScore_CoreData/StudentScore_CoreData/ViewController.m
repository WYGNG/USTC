//
//  ViewController.m
//  StudentScore_CoreData
//
//  Created by XQ on 2019/1/4.
//  Copyright © 2019年 XQ. All rights reserved.
//

#import "ViewController.h"
#import "CoreData/Student+CoreDataClass.h"
@interface ViewController ()
@property (weak, nonatomic) IBOutlet UITextField *name_428;
@property (weak, nonatomic) IBOutlet UITextField *number_428;
@property (weak, nonatomic) IBOutlet UITextField *age_428;
@property (weak, nonatomic) IBOutlet UITextField *score_428;
@property (weak, nonatomic) IBOutlet UITextView *memo_428;
@property (weak, nonatomic) IBOutlet UITextField *teacher_428;
@end

@implementation ViewController

- (IBAction)enter_428:(id)sender {
    
    Student * stu;
    if(self.indexPath == nil){
        stu = [NSEntityDescription insertNewObjectForEntityForName:@"Student" inManagedObjectContext:self.context];
        [self.students addObject:stu];
    }
    else{
        stu = self.students[self.indexPath.row];
    }
    
    stu.name = self.name_428.text;
    stu.number = self.number_428.text;
    stu.age = [self.age_428.text integerValue];
    stu.score = [self.score_428.text floatValue];
    stu.memo = self.memo_428.text;
    stu.learn = self.teacher;
    NSError * error;
    if(![self.context save:&error]) NSLog(@"保存时s出错: %@",error);
    
    
    [self.navigationController popToRootViewControllerAnimated:YES];
    
    
    
}
- (IBAction)cancle_428:(id)sender {
    self.name_428.text = nil;
    self.number_428.text = nil;
    self.age_428.text = nil;
    self.score_428.text = nil;
    self.memo_428.text = nil;
    self.teacher_428.text = nil;
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
        self.teacher_428.text = student.learn.name;
    }
    
    
}














@end
