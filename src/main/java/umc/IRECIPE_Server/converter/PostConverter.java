package umc.IRECIPE_Server.converter;


import org.springframework.data.domain.Page;
import umc.IRECIPE_Server.dto.response.PostResponseDTO;
import umc.IRECIPE_Server.dto.response.ReviewResponseDTO;
import umc.IRECIPE_Server.entity.Member;
import umc.IRECIPE_Server.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostConverter {

    public static PostResponseDTO.postDTO toPostResponseDTO(Post post){
        return PostResponseDTO.postDTO.builder()
                    .postId(post.getId())
                    .build();
        }

    public static PostResponseDTO.getTempDTO toTempResponseDTO(Post post){
        return PostResponseDTO.getTempDTO.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .subhead(post.getSubhead())
                .category(post.getCategory())
                .content(post.getContent())
                .level(post.getLevel())
                .imageUrl(post.getImageUrl())
                .status(post.getStatus())
                .build();
    }



    public static PostResponseDTO.getDTO toGetResponseDTO(Post post, Member member){
        return PostResponseDTO.getDTO.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .subhead(post.getSubhead())
                .content(post.getContent())
                .category(post.getCategory())
                .status(post.getStatus())
                .likes(post.getLikes())
                .level(post.getLevel())
                .score(post.getScore())
                .imageUrl(post.getImageUrl())
                .writerNickName(member.getNickname())
                .writerImage(member.getProfileImage())
                .build();
    }

    public static PostResponseDTO.updateDTO toUpdateResponseDTO(Post post){
        return PostResponseDTO.updateDTO.builder()
                .postId(post.getId())
                .build();
    }

    public static List<PostResponseDTO.getAllPostDTO> toGetAllPostDTO(Page<Post> postPage){
        return postPage.stream()
                .map(m -> PostResponseDTO.getAllPostDTO.builder()
                        .postId(m.getId())
                        .title(m.getTitle())
                        .subhead(m.getSubhead())
                        .imageUrl(m.getImageUrl())
                        .likes(m.getLikes())
                        .score(m.getScore())
                        .reviewsCount(m.getReviewList().size())
                        .nickName(m.getMember().getNickname())
                        .memberImage(m.getMember().getProfileImage())
                        .build())
                .collect(Collectors.toList());
    }

    public static PostResponseDTO.LikePostDTO toLikePostDTO(Post post){
        return PostResponseDTO.LikePostDTO.builder()
                .postId(post.getId())
                .likes(post.getLikes())
                .build();
    }
}
