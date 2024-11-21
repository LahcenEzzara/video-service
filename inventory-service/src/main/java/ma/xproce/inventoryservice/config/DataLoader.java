package ma.xproce.inventoryservice.config;

import ma.xproce.inventoryservice.entities.Creator;
import ma.xproce.inventoryservice.entities.Video;
import ma.xproce.inventoryservice.repositories.CreatorRepository;
import ma.xproce.inventoryservice.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            List<Creator> creators = List.of(Creator.builder().name("John Doe").email("john@example.com").build(), Creator.builder().name("Jane Smith").email("jane@example.com").build());
            creatorRepository.saveAll(creators);

            List<Video> videos = List.of(Video.builder().name("Video 1").url("http://example.com/1").description("First video").datePublication(new Date()).creator(creators.get(0)).build(), Video.builder().name("Video 2").url("http://example.com/2").description("Second video").datePublication(new Date()).creator(creators.get(1)).build());
            videoRepository.saveAll(videos);
        };
    }
}
