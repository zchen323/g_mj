package com.zchen323.mj.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("image")
public class MyResource {

    private static Map<String, Object> map = new HashMap<>();
    static {
        List<Image> images = new ArrayList<>();
        images.add(new Image("", "", "https://raw.githubusercontent.com/zchen323/MJ/master/src/resource/IMG_1525.jpg"));
        images.add(new Image("", "", "https://raw.githubusercontent.com/zchen323/MJ/master/src/resource/IMG_1530.jpg"));
        images.add(new Image("", "", "https://raw.githubusercontent.com/zchen323/MJ/master/src/resource/IMG_1538.jpg"));
        images.add(new Image("", "", "https://raw.githubusercontent.com/zchen323/MJ/master/src/resource/IMG_1540.jpg"));
        images.add(new Image("", "", "https://raw.githubusercontent.com/zchen323/MJ/master/src/resource/IMG_1557.jpg"));
        map.put("12345", images);

        images = new ArrayList<>();
        images.add(new Image("", "", "https://raw.githubusercontent.com/zchen323/MJ/master/src/resource/IMG_1540.jpg"));
        images.add(new Image("", "", "https://raw.githubusercontent.com/zchen323/MJ/master/src/resource/IMG_1568.jpg"));
        images.add(new Image("", "", "https://raw.githubusercontent.com/zchen323/MJ/master/src/resource/IMG_1567.png"));
        images.add(new Image("", "", "https://raw.githubusercontent.com/zchen323/MJ/master/src/resource/IMG_1558.JPG"));
        images.add(new Image("", "", "https://raw.githubusercontent.com/zchen323/MJ/master/src/resource/IMG_1557.jpg"));
        map.put("23456", images);

    }

    @GET
    @Path("catelog")
    @Produces("application/json")
    public Response getCatelog() throws Exception{

        List<Catelog> list = new ArrayList<Catelog>();
//        list.add(new Catelog("12345", "this is a test"));
//        list.add(new Catelog("23456", "this is test 2"));
        list = Util.loadCateLog();
        return Response.ok().entity(list).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getImages(@PathParam("id") String id) throws IOException {

        List<Image> result = Util.loadImages(id);


        return Response.ok().entity(result).build();
    }
}
