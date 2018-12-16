//
//  advanceCalculatorViewController.m
//  CalculaterGUI
//
//  Created by XQ on 2018/12/16.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "advanceCalculatorViewController.h"

@interface advanceCalculatorViewController ()
@property (weak, nonatomic) IBOutlet UIImageView *advancebg_428;

@end

@implementation advanceCalculatorViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/
- (UIStatusBarStyle)preferredStatusBarStyle {
    return UIStatusBarStyleLightContent;
}
- (void)viewWillAppear:(BOOL)animated{
    //self.navigationController.navigationBar.hidden = YES;
    //self.navigationController.navigationBar.barStyle = UIStatusBarStyleLightContent;
    
    UIToolbar * uitoolbar = [[UIToolbar alloc] init];
    uitoolbar.frame = self.advancebg_428.bounds;
    uitoolbar.barStyle = UIBarStyleBlack;
    uitoolbar.alpha = 0.99;
    [self.advancebg_428 addSubview:uitoolbar];
}

@end
