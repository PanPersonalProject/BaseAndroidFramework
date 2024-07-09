package com.example.demo.ui.websocket_demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.demo.R
import com.example.demo.databinding.ActivityWebsocketDemoBinding
import com.therouter.router.Route
import kotlinx.coroutines.launch
import pan.lib.common_lib.base.BaseActivity

@Route(path = "/demo/WebsocketDemoActivity")
class WebsocketDemoActivity : BaseActivity() {
    private val binding: ActivityWebsocketDemoBinding by lazy {
        ActivityWebsocketDemoBinding.inflate(layoutInflater)
    }
    private val websocketDemoViewModel: WebsocketDemoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.websocket_demo)
        enableBack()
        lifecycleScope.launch {
            websocketDemoViewModel.startWebSocketServer()//启动模拟WebServer
            websocketDemoViewModel.connectWebSocket()//连接WebSocket
        }

        binding.buttonSend.setOnClickListener {
            val message = binding.editTextMessage.text.toString()
            if (message.isNotEmpty()) {
                websocketDemoViewModel.sendMessageToWebSocket(message)
                binding.editTextMessage.text.clear()
            }
        }

        websocketDemoViewModel.receivedMessages.observe(this) { message ->
            binding.textViewClientMessages.append("$message\n")
        }


    }

    override fun getLayout(layoutInflater: LayoutInflater): View {
        return binding.root
    }

    override fun onDestroy() {
        websocketDemoViewModel.stopWebSocketServer()
        super.onDestroy()

    }
}
