//�����Ҫ�����߼�js����
// javascript ģ�黯
//seckill.detail.init{params};
var seckill = {
    //������װ��ɱ���ajax��url
    URL: {
        now:function(){
            return "/seckill/time/now";
        },
        exposer:function(seckillId){
            return '/seckill/'+seckillId+'/exposer';
        },
        execution:function(seckillId,md5){
            return '/seckill/'+seckillId+'/'+md5+'/execution';
        }
    },
    handleSeckillKill:function(seckillId,node){
        //��ȡ��ɱ��ַ,����ʵ���߼�,ָ����ɱ
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn"">��ʼ��ɱ</button>');//��ť
        $.post(seckill.exposer(seckillId),{},function(result){
            //�ڻص�������,ִ�н�������
            if(result && result['success']){
                var exposer = result['data'];
                if(exposer['exposed']){
                    //��ʼ��ɱ
                    //��ȡ��ɱ��ַ.
                    var md5 = exposer['md5'];
                    var killUrl = seckill.URL.execution(seckillId,md5);
                    console.log('killUrl:'+killUrl);
                    //��һ�ε���¼�
                    $('killBtn').one('click',function(){
                        //ִ����ɱ����Ĳ���
                        //1.���ð�ť
                        $(this).addClass('disable');
                        //2.������ɱ����,ִ����ɱ
                        $.post(killUrl,{},function(result){
                            if(result && result['success']){
                                var killResult = result['data'];
                                var state = killResult['state'];
                                var stateInfo = killResult['stateInfo'];
                                //��ʾ��ɱ���
                                node.html('<span class="label label-success">'+stateInfo+'</span>');
                            }
                        });
                    });
                    node.show();
                }else{
                    //δ������ɱ
                    var now = exposer['now'];
                    var start = exposer['start'];
                    var end = exposer['end'];
                    //���¼����ʱ�߼�
                    seckill.countdown(seckillId,now,start,end);
                }
            }else{
                console.log('result:'+result)
            }
        });
    },
    //��֤�ֻ���
    validatePhone: function (phone) {
        if (phone && phone.length == 11 && isNaN(phone)){
            return true;
        } else {
            return false;
        }
    },
    countdown:function(seckillId,nowTime,startTime,endTime){
        var seckillBox = $("#seckill-box");
        //ʱ���ж�
        if(nowTime > endTime){
            //��ɱ����
            seckillBox.html('��ɱ����!');
        }else if(nowTime < startTime){
            //��ɱδ��ʼ,��ʱʱ���
            var killTime = new Date(startTime+1000);
            seckillBox.countdown(killTime,function(event){
                //ʱ���ʽ
                var format = event.strftime('��ɱ����ʱ: %�� %ʱ %�� %��');
                seckillBox.html(format);
                /*ʱ����ɹ������ʱ��*/
            }).on("finish.countdown",function(){
                //��ȡ��ɱ��ַ,����ʵ���߼�,ָ����ɱ
                seckill.handleSeckillKill(seckillId.seckillBox);
            });
        }else{
            //��ɱ��ʼ
            seckill.handleSeckillKill(seckillId.seckillBox);
        }

    }
    ,
    //����ҳ��ɱ�߼�
    detail: {
        //����ҳ��ʼ��
        init: function (params) {
            //�ֻ���֤�͵�¼,��ʱ����
            //�滮��������
            //��cookie�в����ֻ���
            var killPhone = $.cookie('killPhone');
            //��֤�ֻ���
            if(!seckill.validatePhone(killPhone)){
                //��phone
                //�������
                var killPhoneModal = $("#killPhoneModal");
                //��ʾ������.
                killPhoneModal.modal({
                    show:true,//��ʾ������
                    backdrop:'static',//��ֹλ�ùر�
                    keyboard:false//�رռ����¼�
                });
                $("#killPhoneBtn").click(function(){
                    var inputPhone = $("#killPhoneKey").val();
                    if(seckill.validatePhone(inputPhone)){
                        //�绰д��Cookie
                        $.cookie("killPhone",inputPhone,{expires:7,path:"/seckill"});
                        //ˢ��ҳ��
                        window.location.reload();
                    }else{
                        $("#killPhoneMessage").hide().html('<label class="label label-danger">�ֻ��Ŵ���!</label>').show(300);
                    }
                });
            }
            //�Ѿ���¼
            //��ʱ����
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];
            $.get(seckill.URL.now(),{},function(result){
                if(result && result["success"]){
                    var nowTime = result["data"];
                    //ʱ���ж�
                    seckill.countdown(seckillId,nowTime,startTime,endTime);
                }else{
                    console.log("result:"+result);
                }
            });
        }
    }
}