package uk.co.breschbrothers.fencingcalc.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import uk.co.breschbrothers.fencingcalc.entity.Post;
import uk.co.breschbrothers.fencingcalc.repositories.PostRepository;

@Component
public class PostConverter implements Converter<String, Post> {

    @Autowired
    private PostRepository postRepository;


    @Override
    public Post convert(String s) {
        return postRepository.findById(Long.parseLong(s)).get();
    }
}
