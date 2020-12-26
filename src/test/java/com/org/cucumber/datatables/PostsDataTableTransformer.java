package com.org.cucumber.datatables;

import com.org.model.Posts;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class PostsDataTableTransformer {

    private final String USER_ID = "userId";

    private final String ID = "id";

    private final String TITLE = "title";

    private final String BODY = "body";

    @DataTableType
    public Posts definePosts(Map<String, String> entry) {
        int userId = Integer.parseInt(entry.get(USER_ID));
        int id = Integer.parseInt(entry.get(ID));
        String title = entry.get(TITLE);
        String body = entry.get(BODY);
        return new Posts(userId, id, title, body);
    }

}
