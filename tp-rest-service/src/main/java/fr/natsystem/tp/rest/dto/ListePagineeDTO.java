package fr.natsystem.tp.rest.dto;

import java.util.ArrayList;
import java.util.List;

public class ListePagineeDTO<T> {
    private final List<T> content = new ArrayList<>();
    private final int page;
    private final long count;

    public ListePagineeDTO(List<T> content, int page, long count) {
        this.content.addAll(content);
        this.page = page;
        this.count = count;
    }

    public List<T> getContent() {
        return content;
    }

    public int getPage() {
        return page;
    }

    public long getCount() {
        return count;
    }
}
