package com.syezdsultanov.bookshelf.booklist;

import android.content.AsyncTaskLoader;
import android.content.Context;
import com.syezdsultanov.bookshelf.utilities.UtilsQuery;

/**
 * Loads a book by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class BookAsyncTask extends AsyncTaskLoader<Book> {

    /**
     * Query URL
     */
    private final String mUrl;

    /**
     * Constructs a new {@link BookAsyncTask}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public BookAsyncTask(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public Book loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a book.
        return UtilsQuery.fetchBookData(mUrl);
    }
}