package com.example.yourpapyrs;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PieceDataService {

    public final String apiURL = "https://www.yourpapyrs.com/api/v1/";
    Context context;

    public PieceDataService(Context context) {
        this.context = context;
    }

    public interface GetPieceListener {
        void onError(String message);

        void onResponse(ArrayList<Piece> pieces);
    }

    public void getPieces(GetPieceListener getPieceListener) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, apiURL + "pieces", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        ArrayList<Piece> pieceArrayList = new ArrayList<>();

                        try {
                            JSONObject data = response.getJSONObject("data");
                            JSONArray pieces = data.getJSONArray("piece");

                            for (int i = 0; i < pieces.length(); i++) {
                                JSONObject pieceData = pieces.getJSONObject(i);
                                Piece piece = new Piece();
                                piece.setAuthorId(pieceData.getString("authorId"));
                                piece.set_id(pieceData.getString("_id"));
                                piece.setTitle(pieceData.getString("title"));
                                piece.setText(pieceData.getString("text"));
                                piece.setAuthor(pieceData.getString("author"));
                                piece.setLikes(pieceData.getJSONArray("likes"));
                                piece.setFlags(pieceData.getJSONArray("flags"));
                                pieceArrayList.add(piece);
                            }

                        } catch (JSONException e) {

                        }
                        getPieceListener.onResponse(pieceArrayList);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                getPieceListener.onError(error.toString());
            }
        }) {
            @NonNull
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                params.put("Accept", "application/json");
                return params;
            }
        };

        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}
