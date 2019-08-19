package core.mvc;

import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public class JsonView implements View {

    private static final String UTF_8 = "UTF-8";

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setCharacterEncoding(UTF_8);

        final PrintWriter writer = response.getWriter();
        final String json = parseJson(model);

        writer.print(json);
        writer.flush();
    }

    private String parseJson(final Map<String, ?> model) {
        if (model == null || model.size() == 0) {
            return "";
        }

        if (model.size() == 1) {
            final ArrayList<?> objects = new ArrayList<>(model.values());
            return JsonUtils.toString(objects.get(0));
        }

        return JsonUtils.toString(model);
    }
}
