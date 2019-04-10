# 类和实体说明
*   Role
    *   用户角色的抽象类，用来描述用户的共有属性和操作
        *   用户角色有uuid、name、session属性分别对应用户唯一标识号、昵称和会话id信息
    *   Administrator
        *   管理员账号，拥有按人查询和按房间查询详情（所有订单信息）的权限、拥有对所有订单的增删操作
    *   User
        *   学生和教师账号，拥有按人（仅限自己）和房间查询占用（是否占用）的权限，拥有对自己的订单的增删操作
    *   Visitor
        *   访客账号，拥有房间查询占用（是否占用）的权限
*   InfoList
    *   封装的订单列表，拥有一个订单数组和数组长度信息
*   Order
    *   订单信息，包含以下属性
        *   classRoom教室对象
        *   user用户对象
        *   startTime开始租借时间
        *   endTime结束租借时间
        *   used是否被使用
        *   breach是否违约
        *   remarks备用信息字段
*   Session
    *   表示活动会话
        *   sessionID:每次成功登陆后下发的会话标识码
*   ClassRoom
    *   教室标识符
        *   name:标识符
*   RequestMessage
    *   （从用户视角而言）发送订单信息，通过接口发送一个该对象即可
        *   数据成员
            *   role:用户角色，表示请求提供方身份标识信息
            *   order:订单信息，表示请求方请求的订单
        *   成员函数
            *   post:调用发送接口，订单信息构造完成后，调用此函数即可提交订单
                *   返回值:statusCode，状态码，用于指示请求结果
*   AcknowledgeMessage
    *   （从用户视角而言）返回订单信息，通过接口发送一个对象
        *   数据成员
            *   RequestMessage中所有数据成员
            *   statusCode添加一个statusCode一并返回
*   StatusCode
    *   状态码，指示操作返回情况，详见[statusCode](./statusCode.md)
*   UserInfo
    *   服务端在客户机上储存的信息结构
    *   类成员
        *   inputUserName输入的用户名
        *   inputUserPassword输入的用户密码的哈希
    *   成员函数
        *   login用户登陆时触发函数，若成功登录则储存session信息
        *   logout清除用户名用户密码和session信息，退出登录