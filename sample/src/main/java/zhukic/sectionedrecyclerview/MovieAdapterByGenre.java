package zhukic.sectionedrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import zhukic.library.SectionedRecyclerAdapter;

/**
 * Created by RUS on 04.09.2016.
 */

public class MovieAdapterByGenre extends SectionedRecyclerAdapter<Movie, MovieAdapterByGenre.ViewHolder> {

    private List<Movie> movieList;

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textMovieName;
        private TextView textMovieGenre;
        private TextView textMovieYear;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textMovieName = (TextView) itemView.findViewById(R.id.movieName);
            this.textMovieGenre = (TextView) itemView.findViewById(R.id.movieGenre);
            this.textMovieYear = (TextView) itemView.findViewById(R.id.movieYear);
        }
    }

    public MovieAdapterByGenre(List<Movie> itemList) {
        super(itemList);
        this.movieList = itemList;
    }

    @Override
    public boolean onItems(Movie o1, Movie o2) {
        return !o1.getGenre().equals(o2.getGenre());
    }

    @Override
    public MovieAdapterByGenre.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new MovieAdapterByGenre.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindItemViewHolder(MovieAdapterByGenre.ViewHolder holder, int position) {
        final Movie movie = movieList.get(position);

        holder.textMovieName.setText(movie.getName());
        holder.textMovieGenre.setText(movie.getGenre());
        holder.textMovieYear.setText(String.valueOf(movie.getYear()));
    }

    @Override
    public void onBindSubheaderViewHolder(SubheaderHolder subheaderHolder, Movie movie) {
        subheaderHolder.mSubheaderText.setText(movie.getGenre());
    }
}
