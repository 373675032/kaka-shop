/**
 * 回复评论
 * @param id
 */
function replyComment(id) {
    xtip.win({
        width: '600px',
        tip: '<div class="card" style="margin: 0px;padding: 0px">\n' +
            '    <div class="card-body" style="padding: 0px">\n' +
            '       <div class="form-group">' +
            '           <textarea placeholder="请填写回复内容 ..." type="text" id="reply" class="form-control"></textarea>' +
            '       </div>' +
            '    </div>\n' +
            '</div>',
        title: '回复评论',
        btn: ['回复'],
        btn1: function () {
            let reply = $("#reply").val().trim();
            if (reply == '') {
                xtip.msg("回复内容不能为空");
                return;
            }
            $.ajax({
                type: "POST",
                url: "replyComment",
                data: {
                    id: id,
                    comment: reply
                },
                dataType: "json",
                success: function (data) {
                    xtip.msg(data['message']);
                    // 等待1秒钟
                    setTimeout("reload()", 1000);
                }
            });
        },
    });

}

/**
 * 删除评论
 * @param id
 */
function deleteComment(id) {
    $.ajax({
        type: "POST",
        url: "deleteComment",
        data: {
            id: id,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            // 等待1秒钟
            setTimeout("reload()", 1000);
        }
    });
}

/**
 * 添加收货地址
 */
function addAddress() {
    let name = $("#name").val().trim();
    let address = $("#address").val().trim();
    let phone = $("#phone").val().trim();
    if (name == '') {
        xtip.msg("姓名不能为空");
        return;
    }
    if (address == '') {
        xtip.msg("地址不能为空");
        return;
    }
    if (phone == '') {
        xtip.msg("手机号不能为空");
        return;
    }
    $.ajax({
        type: "POST",
        url: "addAddress",
        data: {
            name: name,
            address: address,
            phone: phone,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            // 等待1秒钟
            setTimeout("reload()", 1000);
        }
    });
}

/**
 * 删除地址
 * @param id
 */
function deleteAddress(id) {
    $.ajax({
        type: "POST",
        url: "deleteAddress",
        data: {
            id: id
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            // 等待1秒钟
            setTimeout("reload()", 1000);
        }
    });
}

/**
 * 更新地址默认状态
 * @param id
 */
function updateAddress(id) {
    $.ajax({
        type: "POST",
        url: "updateAddress",
        data: {
            id: id
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            // 等待1秒钟
            setTimeout("reload()", 1000);
        }
    });
}

/**
 * 商品发货
 * @param id
 */
function deliverGoods(id) {
    xtip.win({
        width: '600px',
        tip: '<div class="card" style="margin: 0px;padding: 0px">\n' +
            '    <div class="card-body" style="padding: 0px">\n' +
            '       <div class="form-group">' +
            '           <input placeholder="快递单号" type="text" id="courierNumber" class="form-control">' +
            '       </div>' +
            '       <div class="form-group">' +
            '           <select class="form-control" placeholder="请选择快递公司" id="courierName">' +
            '               <option value="顺丰快递">顺丰快递</option>' +
            '               <option value="韵达快递">韵达快递</option>' +
            '               <option value="圆通快递">圆通快递</option>' +
            '               <option value="申通快读">申通快读</option>' +
            '               <option value="邮政EMS">邮政EMS</option>' +
            '           </select>' +
            '       </div>' +
            '    </div>\n' +
            '</div>',
        title: '填写发货信息',
        btn: ['发货'],
        btn1: function () {
            let courierNumber = $("#courierNumber").val().trim();
            let courierName = $('#courierName').find('option:selected').val();
            if (courierNumber == '') {
                xtip.msg("快递单号不能为空");
                return;
            }

            $.ajax({
                type: "POST",
                url: "deliverGoods",
                data: {
                    id: id,
                    courierNumber: courierNumber,
                    courierName: courierName,
                },
                dataType: "json",
                success: function (data) {
                    xtip.msg(data['message']);
                    // 等待1秒钟
                    setTimeout("reload()", 1000);
                }
            });
        },
    });
}

/**
 * 购买商品
 * @param id
 */
function buyCommodity(id) {
    let addressId = $('#addressId').find('option:selected').val();
    $.ajax({
        type: "POST",
        url: "buyCommodity",
        data: {
            cartId: id,
            addressId: addressId
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reloadTo('/success.html')", 1000);
            }
        }
    });
}

/**
 * 删除订单
 * @param id
 */
function deleteOrder(id) {
    $.ajax({
        type: "POST",
        url: "deleteOrder",
        data: {
            id: id,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });
}

/**
 * 确认收货
 * @param id
 */
function confirmOrder(id) {
    $.ajax({
        type: "POST",
        url: "confirmOrder",
        data: {
            id: id,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });
}

/**
 * 添加商品评论
 * @param id
 */
function addComment(id) {
    let stars = $("#stars").val().trim();
    let comment = $("#comment").val().trim();

    if (stars == '') {
        xtip.msg("星星数不能为空");
        return;
    }
    if (comment == '') {
        xtip.msg("评论不能为空");
        return;
    }
    if (stars != 1 && stars != 2 && stars != 3 && stars != 4 && stars != 5) {
        xtip.msg("星星数请填写【1 - 5】的整数");
        return;
    }
    $.ajax({
        type: "POST",
        url: "addComment",
        data: {
            id: id,
            stars: stars,
            comment: comment,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reloadTo('/product?id='+" + id + ")", 1000);
            }
        }
    });
}

/**
 * 取消订单
 * @param id
 */
function cancelOrder(id) {
    $.ajax({
        type: "POST",
        url: "cancelOrder",
        data: {
            id: id,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload('/my-order?status=-1')", 1000);
            }
        }
    });
}

/**
 * 加入购物车
 * @param id
 * @param count
 */
function addCart(id, count) {
    $.ajax({
        type: "POST",
        url: "addCart",
        data: {
            commodityId: id,
            count: count
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reloadTo('/cart')", 1000);
            }
        }
    });
}

/**
 * 修改购物车的数量
 * @param id
 * @param type
 */
function changeCartCount(id, type) {
    let count = $("#count" + id).val();
    if (type == '-') {
        if (count == 1) {
            return;
        }
        count--;
    }
    if (type == '+') {
        count++;
    }
    $.ajax({
        type: "POST",
        url: "changeCartCount",
        data: {
            id: id,
            count: count
        },
        dataType: "json",
        success: function (data) {
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            } else {
                xtip.msg(data['message']);
            }
        }
    });
}

/**
 * 加入购物车
 * @param id
 */
function addToCart(id) {
    let count = $("#count").val().trim();
    addCart(id, count);
}

/**
 * 删除购物车
 * @param id
 */
function deleteCart(id) {
    $.ajax({
        type: "POST",
        url: "deleteCart",
        data: {
            id: id,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });
}

/**
 * 删除分类
 * @param id
 */
function deleteClassify(id) {
    $.ajax({
        type: "POST",
        url: "deleteClassify",
        data: {
            id: id,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });
}

/**
 * 新增商品分类
 */
function addClassify() {
    let name = $("#newClassify").val().trim();
    if (name == '') {
        xtip.msg("名称不能为空");
        return;
    }
    $.ajax({
        type: "POST",
        url: "addClassify",
        data: {
            name: name,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });
}

/**
 * 更新商品分类名称
 */
function updateClassify(id) {
    let name = $("#classify" + id).val().trim();
    if (name == '') {
        xtip.msg("名称不能为空");
        return;
    }
    $.ajax({
        type: "POST",
        url: "updateClassify",
        data: {
            id: id,
            name: name,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });
}

/**
 * 微信公众号弹窗
 */
function publicWeChat() {
    xtip.win({
        type: 'alert', //alert 或 confirm
        btn: ['关闭'],
        tip: '<img height="300px" width="300px" src="https://gitee.com/cn_moti/mdnice/raw/master/typora/20210303220817.jpg"/>',
        icon: '',
        title: "微信公众号：我是XUEW",
        min: true,
        width: '300px',
        shade: true,
        shadeClose: false,
        lock: false,
        zindex: 99999,
    });
}

/**
 * 请求模版
 */
function ajaxTemplate() {
    let password = $("#password").val().trim();
    let role = $('#role').find('option:selected').val();
    let year = $("#year").find('option:selected').val();
    $.ajax({
        type: "POST",
        url: "applyMeeting",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });
}

/**
 * 登陆
 */
function login() {
    let email = $("#email").val().trim();
    let password = $("#password").val().trim();

    // 验证邮箱格式
    if (!isEmail(email)) {
        xtip.msg("邮箱格式不正确");
        return;
    }
    // 验证密码格式
    if (!isPassword(password)) {
        xtip.msg("密码格式：6到16位字符且包含字母和数字");
        return;
    }
    $.ajax({
        type: "POST",
        url: "login",
        data: {email: email, password: password},
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reloadTo('/index.html')", 1000);
            }
        }
    });
}

/**
 * 用户注册
 */
function register() {
    let username = $("#username").val().trim();
    let email = $("#email").val().trim();
    let password = $("#password").val().trim();
    // 用户名不能为空
    if (username == '') {
        xtip.msg("用户名不能为空");
        return;
    }
    // 验证邮箱格式
    if (!isEmail(email)) {
        xtip.msg("邮箱格式不正确");
        return;
    }
    // 验证密码格式
    if (!isPassword(password)) {
        xtip.msg("密码格式：6到16位字符且包含字母和数字");
        return;
    }
    $.ajax({
        type: "POST",
        url: "register",
        data: {email: email, password: password, username: username},
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reloadTo('/login.html')", 1000);
            }
        }
    });
}

/**
 * 修改用户资料
 */
function updateProfile() {
    let username = $("#username").val().trim();
    let email = $("#email").val().trim();
    let info = $("#info").val().trim();
    // 用户名不能为空
    if (username == '') {
        xtip.msg("用户名不能为空");
        return;
    }
    // 个人说明不能为空
    if (info == '') {
        xtip.msg("个人说明不能为空");
        return;
    }
    // 验证邮箱格式
    if (!isEmail(email)) {
        xtip.msg("邮箱格式不正确");
        return;
    }
    $.ajax({
        type: "POST",
        url: "updateProfile",
        data: {email: email, info: info, username: username},
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });

}


/**
 * 修改密码
 */
function updatePassword() {
    let newPassword = $("#new-password").val().trim();
    let oldPassword = $("#old-password").val().trim();
    // 验证密码格式
    if (!isPassword(oldPassword)) {
        xtip.msg("旧密码格式不正确：6到16位字符且包含字母和数字");
        return;
    }
    // 验证密码格式
    if (!isPassword(newPassword)) {
        xtip.msg("新密码格式不正确：6到16位字符且包含字母和数字");
        return;
    }

    $.ajax({
        type: "POST",
        url: "updatePassword",
        data: {newPassword: newPassword, oldPassword: oldPassword},
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });
}

/**
 * 忘记密码
 */
function forgetPassword() {
    let email = $("#email").val().trim();
    // 验证邮箱格式
    if (!isEmail(email)) {
        xtip.msg("邮箱格式不正确");
        return;
    }
    $.ajax({
        type: "POST",
        url: "forgetPassword",
        data: {email: email},
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });
}

/**
 * 上传用户头像
 */
function uploadAvatar() {
    var formdata = new FormData();
    formdata.append("avatar", $("#avatar").get(0).files[0]);
    $.ajax({
        async: false,
        type: "POST",
        url: "uploadAvatar",
        dataType: "json",
        data: formdata,
        contentType: false,
        processData: false,
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });
}

/**
 * 上传商品图片
 */
function uploadGoodsImg() {
    var formdata = new FormData();
    formdata.append("imgFile", $("#img_file").get(0).files[0]);
    $.ajax({
        async: false,
        type: "POST",
        url: "uploadGoodsImg",
        dataType: "json",
        data: formdata,
        contentType: false,
        processData: false,
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                $('#img').attr('src', data.url);
                $('#img_path').attr('value', data.url);
            }
        }
    });
}

/**
 * 发布新品商品
 */
function publishNewGoods() {
    let name = $("#name").val().trim();
    let color = $("#color").val().trim();
    let material = $("#material").val().trim();
    let origin = $("#origin").val().trim();
    let original_price = $("#original_price").val().trim();
    let now_price = $("#now_price").val().trim();
    let inventory = $("#inventory").val().trim();
    let classify = $('#classify').find('option:selected').val();
    let status = $('#status').find('option:selected').val();
    let img_path = $("#img_path").val().trim();
    let info = $("#info").val().trim();
    let description = $("#description").val().trim();

    if (name == '') {
        xtip.msg("商品名称不能为空");
        return;
    }
    if (color == '') {
        xtip.msg("商品颜色不能为空");
        return;
    }
    if (material == '') {
        xtip.msg("商品原材料不能为空");
        return;
    }
    if (origin == '') {
        xtip.msg("商品产地不能为空");
        return;
    }
    if (original_price == '') {
        xtip.msg("商品原价不能为空");
        return;
    }
    if (now_price == '') {
        xtip.msg("商品现价不能为空");
        return;
    }
    if (inventory == '') {
        xtip.msg("商品库存不能为空");
        return;
    }
    if (img_path == '') {
        xtip.msg("请上传商品图片");
        return;
    }
    if (info == '') {
        xtip.msg("商品简介不能为空");
        return;
    }
    if (description == '') {
        xtip.msg("商品描述不能为空");
        return;
    }

    $.ajax({
        type: "POST",
        url: "publishNewGoods",
        data: {
            name: name,
            info: info,
            description: description,
            color: color,
            material: material,
            origin: origin,
            classifyId: classify,
            originalPrice: original_price,
            nowPrice: now_price,
            inventory: inventory,
            status: status,
            img: img_path,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });

}

/**
 * 更改商品状态
 */
function changeStatus(id) {
    $.ajax({
        type: "POST",
        url: "changeStatus",
        data: {
            id: id
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
        }
    });
}

/**
 * 更改用户角色
 */
function changeRole(id) {
    $.ajax({
        type: "POST",
        url: "changeRole",
        data: {
            id: id
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
        }
    });
}

/**
 * 修改用户资料
 * @param id
 * @param name
 * @param email
 * @param password
 * @param info
 */
function updateUserInfo(id, name, email, password, info) {
    xtip.win({
        width: '600px',
        tip: '<div class="card" style="margin: 0px;padding: 0px">\n' +
            '    <div class="card-body" style="padding: 0px">\n' +
            '       <div class="form-group">' +
            '           <input placeholder="用户名" type="text" id="name" class="form-control" value="' + name + '">' +
            '       </div>' +
            '       <div class="form-group">' +
            '           <input placeholder="密码" type="text" id="password" class="form-control" value="' + password + '">' +
            '       </div>' +
            '       <div class="form-group">' +
            '           <input placeholder="邮箱" type="email" id="email" class="form-control" value="' + email + '">' +
            '       </div>' +
            '       <div class="form-group">\n' +
            '           <textarea id="info" style="height:150px" class="form-control" placeholder="个人说明 ...">' + info + '</textarea>' +
            '       </div>' +
            '    </div>\n' +
            '</div>',
        title: '修改 ' + name + ' 的资料',
        btn: ['修改'],
        btn1: function () {
            let name = $("#name").val().trim();
            let password = $("#password").val().trim();
            let email = $("#email").val().trim();
            let info = $("#info").val().trim();
            if (name == '') {
                xtip.msg("用户名不能为空");
                return;
            }
            if (password == '') {
                xtip.msg("密码不能为空");
                return;
            }
            if (email == '') {
                xtip.msg("邮箱不能为空");
                return;
            }
            if (info == '') {
                info = "";
            }

            $.ajax({
                type: "POST",
                url: "updateUserInfo",
                data: {
                    id: id,
                    name: name,
                    password: password,
                    email: email,
                    info: info
                },
                dataType: "json",
                success: function (data) {
                    xtip.msg(data['message']);
                    // 等待1秒钟
                    setTimeout("reload()", 1000);
                }
            });
        },
    });
}

/**
 * 通过分类查询
 */
function searchByClassifyId() {
    let classifyId = $('#classifyId').find('option:selected').val();
    if (classifyId == 'all') {
        reloadTo('/list')
    } else {
        reloadTo('/list?classifyId=' + classifyId);
    }
}

/**
 * 收藏
 */
function doCollect(id) {
    $.ajax({
        type: "POST",
        url: "doCollect",
        data: {
            id: id
        },
        dataType: "json",
        success: function (data) {
            // 等待1秒钟
            xtip.msg(data['message']);
            setTimeout("reload()", 1000);
        }
    });
}

/**
 * 取消收藏
 */
function undoCollect(id) {
    $.ajax({
        type: "POST",
        url: "undoCollect",
        data: {
            id: id
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            // 等待1秒钟
            setTimeout("reload()", 1000);
        }
    });
}

/**
 * 编辑商品
 */
function editGoods() {
    let id = $("#id").val().trim();
    let name = $("#name").val().trim();
    let color = $("#color").val().trim();
    let material = $("#material").val().trim();
    let origin = $("#origin").val().trim();
    let original_price = $("#original_price").val().trim();
    let now_price = $("#now_price").val().trim();
    let inventory = $("#inventory").val().trim();
    let classify = $('#classify').find('option:selected').val();
    let status = $('#status').find('option:selected').val();
    let img_path = $("#img_path").val().trim();
    let info = $("#info").val().trim();
    let description = $("#description").val().trim();

    if (name == '') {
        xtip.msg("商品名称不能为空");
        return;
    }
    if (color == '') {
        xtip.msg("商品颜色不能为空");
        return;
    }
    if (material == '') {
        xtip.msg("商品原材料不能为空");
        return;
    }
    if (origin == '') {
        xtip.msg("商品产地不能为空");
        return;
    }
    if (original_price == '') {
        xtip.msg("商品原价不能为空");
        return;
    }
    if (now_price == '') {
        xtip.msg("商品现价不能为空");
        return;
    }
    if (inventory == '') {
        xtip.msg("商品库存不能为空");
        return;
    }
    if (img_path == '') {
        xtip.msg("请上传商品图片");
        return;
    }
    if (info == '') {
        xtip.msg("商品简介不能为空");
        return;
    }
    if (description == '') {
        xtip.msg("商品描述不能为空");
        return;
    }

    $.ajax({
        type: "POST",
        url: "editGoods",
        data: {
            id: id,
            name: name,
            info: info,
            description: description,
            color: color,
            material: material,
            origin: origin,
            classifyId: classify,
            originalPrice: original_price,
            nowPrice: now_price,
            inventory: inventory,
            status: status,
            img: img_path,
        },
        dataType: "json",
        success: function (data) {
            xtip.msg(data['message']);
            if (data['code'] == 200) {
                // 等待1秒钟
                setTimeout("reload()", 1000);
            }
        }
    });

}

/**
 * ok
 */
function ok() {
    alert("ok")
}

/**
 * 刷新页面
 */
function reload() {
    window.location.reload();
}

/**
 * 跳转到指定页面
 * url 例如 /hello
 */
function reloadTo(url) {
    url = url.trim();
    let href = window.location.href;
    href = href.split("/kaka-shop")[0];
    if (url != null && url != '') {
        window.location.href = href + "/kaka-shop" + url;
    }
}

/**
 * 检查手机号格式
 * @param phone
 * @returns {boolean}
 */
function isPhone(phone) {
    var reg = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;
    return reg.test(phone);
}

/**
 * 检查邮箱格式
 * @param email
 * @returns {boolean}
 */
function isEmail(email) {
    var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    return reg.test(email);
}

/**
 * 验证密码格式
 * @param password
 */
function isPassword(password) {
    var reg = /^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]{6,16})$/;
    return reg.test(password);
}