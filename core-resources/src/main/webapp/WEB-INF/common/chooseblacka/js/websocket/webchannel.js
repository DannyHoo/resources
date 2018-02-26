var i = 1;
var textArea = document.getElementById("receive");
textArea.addEventListener('change', function () {
    var obj = document.getElementById("receive");
    obj.value += i + "\n";
    i++;
    obj.scrollTop = obj.scrollHeight;
});

var Webchannel = {
    websocket: "",
    wsUrl: "ws://" + window.location.host + "/myHandler?groupCode="+$("#groupCode").val()+"&userId="+$("#userId").val(),
    busiTypes: {},
    initWebsocket: function () {
        console.log("ws访问地址："+Webchannel.wsUrl);
        if ("WebSocket" in window) {
            websocket = new WebSocket(Webchannel.wsUrl);
            /*websocket = new ReconnectingWebSocket("ws://"
                + host + "/webSocketIMServer", null, {debug:true, maxReconnectAttempts:4});*/
        } else if ("MozWebSocket" in window) {
            websocket = new MozWebSocket(Webchannel.wsUrl);
        } else {
            console.log("The browser don't support the WebSocket");
        }
        websocket.onopen = function () {
            console.log("connect success");
        };
        websocket.onclose = function () {
            try {
                websocket = new WebSocket(Webchannel.wsUrl);
            } catch (e) {
                console.log("disconnect error" + e);
            }
            console.log("disconnect success");
        };
        websocket.onerror = function () {
            console.log("sorry,it get error");
        };
        websocket.onmessage = function (receiveMsg) {
            var str = $("#receive").val();
            var reMsg = receiveMsg.data.substring(1, receiveMsg.data.length - 1);
            reMsg = receiveMsg.data;
            $("#receive").val(str + "\n" + reMsg);
        }
    },
    sendMsg: function (data) {
        var jsonData = JSON.stringify(data);
        websocket.send(jsonData);
    },

    closeWebSocket: function () {
        if (1 == websocket.readyState) {
            websocket.close();
            websocket = "";
        }
    },
    regBusitype: function (busiType, backFunction) {
        Webchannel.busiTypes[busiType] = backFunction;
    }
};

Webchannel.initWebsocket();

function send() {
    var data = $("#send").val();
    $("#send").val("");
    Webchannel.sendMsg(data);
}