//
//  ViewController.m
//  SA18225428_2
//
//  Created by XQ on 2019/1/10.
//  Copyright © 2019 XQ. All rights reserved.
//

#import "ViewController.h"
#import "secondViewController.h"
@interface ViewController ()
@property (weak, nonatomic) IBOutlet UITextField *sa428_text;
//@property (weak, nonatomic) secondViewController * secondviewController;
@end

@implementation ViewController

- (void)viewDidLoad {
    _sa428_text.text = self.string;
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender{
    
    if([segue.identifier isEqualToString:@"words"]){
        secondViewController * svc =  segue.destinationViewController;
        svc.ns = _sa428_text.text;
    }
}

@end
