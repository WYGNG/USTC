//
//  ViewController.m
//  SA18225428_5
//
//  Created by XQ on 2019/1/10.
//  Copyright © 2019 XQ. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
@property (weak, nonatomic) IBOutlet UITextField *sa428_username;
@property (weak, nonatomic) IBOutlet UITextField *sa428_password;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender{
    
    if([segue.identifier isEqualToString:@"login"]){
        if([_sa428_username.text isEqualToString:@"admin"] && [_sa428_password.text isEqualToString:@"123" ]){
            
        }
        if([_sa428_username.text isEqualToString:@"user"] && [_sa428_password.text isEqualToString:@"456" ]){
            
        }
    }
}





@end
