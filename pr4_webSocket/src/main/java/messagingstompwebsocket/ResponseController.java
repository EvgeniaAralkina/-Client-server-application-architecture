package messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ResponseController {

	@MessageMapping("/webs")
	@SendTo("/topic/response")
	public Response greeting(HelloMessage message) throws Exception {
		return new Response(HtmlUtils.htmlEscape(message.getName()));
	}

}
