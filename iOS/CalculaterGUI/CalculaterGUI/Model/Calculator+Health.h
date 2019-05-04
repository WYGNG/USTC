//
//  Calculator+Health.h
//  CalculaterGUI
//
//  Created by XQ on 2018/12/20.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "Calculator.h"

NS_ASSUME_NONNULL_BEGIN

@interface Calculator (Health)
- (NSString *)computeHealthWithHeight:(NSString *) height withWeight: (NSString *) weight;
@end

NS_ASSUME_NONNULL_END
