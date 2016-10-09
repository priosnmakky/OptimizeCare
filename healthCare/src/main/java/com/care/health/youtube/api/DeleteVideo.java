package com.care.health.youtube.api;
import com.care.health.model.YoutubeVideo;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Videos;
import com.google.api.services.youtube.YouTube.Videos.Delete;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.common.collect.Lists;
import com.google.api.services.sample.youtube.Auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Update a video by adding a keyword tag to its metadata. The demo uses the
 * YouTube Data API (v3) and OAuth 2.0 for authorization.
 *
 * @author Ibrahim Ulukaya
 */
public class DeleteVideo {

    /**
     * Define a global instance of a Youtube object, which will be used
     * to make YouTube Data API requests.
     */
    private static YouTube youtube;

    /**
     * Add a keyword tag to a video that the user specifies. Use OAuth 2.0 to
     * authorize the API request.
     *
     * @param args command line args (not used).
     */
    
    public void deleteVideo(YoutubeVideo youtubeVideo){
    	 List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube");

         try {
             // Authorize the request.
             Credential credential = Auth.authorize(scopes, "deletevideo");

             // This object is used to make YouTube Data API requests.
             youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
                     .setApplicationName("youtube-cmdline-updatevideo-sample").build();

             // Prompt the user to enter the video ID of the video being updated.
//             String videoId = getVideoIdFromUser();
//             System.out.println("You chose " + videoId + " to update.");
//
//             // Prompt the user to enter a keyword tag to add to the video.
//             String tag = getTagFromUser();
//             System.out.println("You chose " + tag + " as a tag.");
//
//             // Call the YouTube Data API's youtube.videos.list method to
//             // retrieve the resource that represents the specified video.
//             YouTube.Videos.List listVideosRequest = youtube.videos().list("snippet").setId(videoId);
//             VideoListResponse listResponse = listVideosRequest.execute();
//             
//             // Since the API request specified a unique video ID, the API
//             // response should return exactly one video. If the response does
//             // not contain a video, then the specified video ID was not found.
//             List<Video> videoList = listResponse.getItems();
//             if (videoList.isEmpty()) {
//                 System.out.println("Can't find a video with ID: " + videoId);
//                 return;
//             }
//
//             // Extract the snippet from the video resource.
//             Video video = videoList.get(0);
//             List<String> tags1 = new ArrayList<String>();
//             //tags1.add("makky");
//             video.getSnippet().setTitle("ทดสอบ");
//             VideoSnippet snippet = video.getSnippet();
           ///  video.e

             // Preserve any tags already associated with the video. If the
             // video does not have any tags, create a new array. Append the
//             // provided tag to the list of tags associated with the video.
//             List<String> tags = snippet.getTags();
//             if (tags == null) {
//                 tags = new ArrayList<String>(1);
//                 snippet.setTags(tags);
//             }
//             tags.add(tag);

             // Update the video resource by calling the videos.update() method.
        //     YouTube.Videos.Update updateVideosRequest = youtube.videos().
           YouTube.Videos.Delete dVideosRequest =  youtube.videos().delete(youtubeVideo.getId());
         //    YouTube.Videos.Update updateVideosRequest = youtube.videos().update("snippet", video);
            dVideosRequest.execute();
             
             
          ///   YouTube.Videos.Delete  makky= youtube.videos().delete("snippet").setId("ZvVqXYKvBQ4");

             
         ///   https://www.youtube.com/watch?v=ZvVqXYKvBQ4

//             // Print information from the updated resource.
             System.out.println("\n================== Returned Video ==================\n");
          //   System.out.println("  - Title: " + videoResponse.getSnippet().getTitle());
             //System.out.println("  - Tags: " + videoResponse.getSnippet().getTags());

         } catch (GoogleJsonResponseException e) {
             System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode() + " : "
                     + e.getDetails().getMessage());
             e.printStackTrace();
         } catch (IOException e) {
             System.err.println("IOException: " + e.getMessage());
             e.printStackTrace();
         } catch (Throwable t) {
             System.err.println("Throwable: " + t.getMessage());
             t.printStackTrace();
         }
    }
    public static void main(String[] args) {

        // This OAuth 2.0 access scope allows for full read/write access to the
        // authenticated user's account.
        List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube");

        try {
            // Authorize the request.
            Credential credential = Auth.authorize(scopes, "deletevideo");

            // This object is used to make YouTube Data API requests.
            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
                    .setApplicationName("youtube-cmdline-updatevideo-sample").build();

            // Prompt the user to enter the video ID of the video being updated.
            String videoId = getVideoIdFromUser();
            System.out.println("You chose " + videoId + " to update.");

            // Prompt the user to enter a keyword tag to add to the video.
            String tag = getTagFromUser();
            System.out.println("You chose " + tag + " as a tag.");

            // Call the YouTube Data API's youtube.videos.list method to
            // retrieve the resource that represents the specified video.
            YouTube.Videos.List listVideosRequest = youtube.videos().list("snippet").setId(videoId);
            VideoListResponse listResponse = listVideosRequest.execute();
            
            // Since the API request specified a unique video ID, the API
            // response should return exactly one video. If the response does
            // not contain a video, then the specified video ID was not found.
            List<Video> videoList = listResponse.getItems();
            if (videoList.isEmpty()) {
                System.out.println("Can't find a video with ID: " + videoId);
                return;
            }

            // Extract the snippet from the video resource.
            Video video = videoList.get(0);
            List<String> tags1 = new ArrayList<String>();
            //tags1.add("makky");
            video.getSnippet().setTitle("ทดสอบ");
            VideoSnippet snippet = video.getSnippet();
          ///  video.e

            // Preserve any tags already associated with the video. If the
            // video does not have any tags, create a new array. Append the
            // provided tag to the list of tags associated with the video.
            List<String> tags = snippet.getTags();
            if (tags == null) {
                tags = new ArrayList<String>(1);
                snippet.setTags(tags);
            }
            tags.add(tag);

            // Update the video resource by calling the videos.update() method.
       //     YouTube.Videos.Update updateVideosRequest = youtube.videos().
          YouTube.Videos.Delete dVideosRequest =  youtube.videos().delete("ddm41wXzmeM");
        //    YouTube.Videos.Update updateVideosRequest = youtube.videos().update("snippet", video);
           dVideosRequest.execute();
            
            
         ///   YouTube.Videos.Delete  makky= youtube.videos().delete("snippet").setId("ZvVqXYKvBQ4");

            
        ///   https://www.youtube.com/watch?v=ZvVqXYKvBQ4

//            // Print information from the updated resource.
            System.out.println("\n================== Returned Video ==================\n");
         //   System.out.println("  - Title: " + videoResponse.getSnippet().getTitle());
            //System.out.println("  - Tags: " + videoResponse.getSnippet().getTags());

        } catch (GoogleJsonResponseException e) {
            System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            e.printStackTrace();
        } catch (Throwable t) {
            System.err.println("Throwable: " + t.getMessage());
            t.printStackTrace();
        }
    }

    /*
     * Prompt the user to enter a keyword tag.
     */
    private static String getTagFromUser() throws IOException {

        String keyword = "";

        System.out.print("Please enter a tag for your video: ");
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        keyword = bReader.readLine();

        if (keyword.length() < 1) {
            // If the user doesn't enter a tag, use the default value "New Tag."
            keyword = "New Tag";
        }
        return keyword;
    }

    /*
     * Prompt the user to enter a video ID.
     */
    private static String getVideoIdFromUser() throws IOException {

        String videoId = "";

        System.out.print("Please enter a video Id to update: ");
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        videoId = bReader.readLine();

        if (videoId.length() < 1) {
            // Exit if the user doesn't provide a value.
            System.out.print("Video Id can't be empty!");
            System.exit(1);
        }

        return videoId;
    }

}