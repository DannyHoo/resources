var i = 1;
var textArea = document.getElementById("receive");
textArea.addEventListener('input', function () {
    var obj = document.getElementById("receive");
    obj.value += i + "\n";
    i++;
    obj.scrollTop = obj.scrollHeight;
});


var Webchannel = {
    wso: "",
    wsUrl: "ws://" + window.location.host + "/myHandler/1/1",
    busiTypes: {},
    initWebsocket: function () {
        if ("WebSocket" in window) {
            wso = new WebSocket(Webchannel.wsUrl);
        } else if ("MozWebSocket" in window) {
            wso = new MozWebSocket(Webchannel.wsUrl);
        } else {
            console.log("The browser don't support the WebSocket");
        }
        wso.onopen = function () {
            console.log("connect success");
        };
        wso.onclose = function () {
            try {
                wso = new WebSocket(Webchannel.wsUrl);
            } catch (e) {
                console.log("disconnect error" + e);
            }
            console.log("disconnect success");
        };
        wso.onerror = function () {
            console.log("sorry,it get error");
        };
        wso.onmessage = function (receiveMsg) {
            var str = $("#receive").val();
            var reMsg = receiveMsg.data.substring(1, receiveMsg.data.length - 1);
            reMsg = receiveMsg.data;
            $("#receive").val(str + "\n" + reMsg);
        }
    },
    sendMsg: function (data) {
        var jsonData = JSON.stringify(data);
        wso.send(jsonData);
    },

    closeWebSocket: function () {
        if (1 == wso.readyState) {
            wso.close();
            wso = "";
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